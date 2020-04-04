package com.kodekonveyor.work_request.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@RestController
public class GiveofferController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @Autowired
  OfferEntityRepository offerEntityRepository;

  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @PostMapping("/offer")
  public OfferDTO
      call(@RequestBody final OfferDTO offerDTO) {
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
    offerEntity.setWorkRequest(
        workRequestRepository.findByWorkRequestId(offerDTO.getWorkRequestId()).get(0)
    );
    offerEntity.setProvider(userEntity);
    offerEntityRepository.save(offerEntity);
  }

}
