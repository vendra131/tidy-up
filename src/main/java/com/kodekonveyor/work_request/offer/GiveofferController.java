package com.kodekonveyor.work_request.offer;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestRepository;

@RestController
public class GiveofferController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @Autowired
  OfferEntityRepository offerEntityRepository;

  @Autowired
  AuthenticatedUserService authenticatedUserService;
  @Autowired
  Logger loggerService;

  @PostMapping("/offer")
  public OfferDTO
      call(@RequestBody final OfferDTO offerDTO) {
    loggerService.info(
        WorkRequestConstants.SERVICE_CALL_NAME, this.getClass().getName()
    );
    loggerService.info(WorkRequestConstants.INPUT_VALIDATION, offerDTO.getId());
    OfferValidationUtil.inputValidation(workRequestRepository, offerDTO);

    final UserEntity userEntity = authenticatedUserService.call();
    giveOfferToUser(offerDTO, userEntity);
    return offerDTO;
  }

  private void
      giveOfferToUser(final OfferDTO offerDTO, final UserEntity userEntity) {
    final OfferEntity offerEntity = new OfferEntity();
    offerEntity.setId(offerDTO.getId());
    offerEntity.setPrice(offerDTO.getPrice());
    loggerService.info(
        WorkRequestConstants.FIND_WORK_REQUEST, offerDTO.getWorkRequestId()
    );
    offerEntity.setWorkRequest(
        workRequestRepository.findByWorkRequestId(offerDTO.getWorkRequestId()).get(0)
    );
    loggerService.debug(
        WorkRequestConstants.FIND_WORK_REQUEST_STATUS,
        offerEntity.getWorkRequest(), WorkRequestConstants.SUCCESS
    );
    offerEntity.setProvider(userEntity);
    loggerService.info(WorkRequestConstants.SAVE_OFFER, offerEntity.getId());
    offerEntityRepository.save(offerEntity);
    loggerService.debug(
        WorkRequestConstants.SAVE_OFFER_STATUS, offerEntity.getId(),
        WorkRequestConstants.SUCCESS
    );
  }

}
