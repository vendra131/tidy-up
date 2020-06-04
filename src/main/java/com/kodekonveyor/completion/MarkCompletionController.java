package com.kodekonveyor.completion;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.work_request.AddressDTO;
import com.kodekonveyor.work_request.AddressEntity;
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

import static com.kodekonveyor.completion.CompletionConstants.FAILURE;
import static com.kodekonveyor.completion.CompletionConstants.INVALID_WORK_REQUEST_STATUS;
import static com.kodekonveyor.completion.CompletionConstants.LOG_API_CALL;
import static com.kodekonveyor.completion.CompletionConstants.LOG_API_CALL_FALURE_STATUS;
import static com.kodekonveyor.completion.CompletionConstants.LOG_API_CALL_STATUS;
import static com.kodekonveyor.completion.CompletionConstants.SUCCESS;

@RestController
public class MarkCompletionController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @Autowired
  Logger loggerService;

  @PutMapping("/completed/{workRequestId}")
  public WorkRequestDTO call(final Long workRequestId) {

    loggerService.info(LOG_API_CALL);

    final List<WorkRequestEntity> entities =
        workRequestRepository.findByWorkRequestId(workRequestId);

    final WorkRequestEntity entity = entities.get(0);

    if (!entity.getStatus().equals(WorkRequestStatusEnum.AGREED)) {
      loggerService.warn(
              LOG_API_CALL_FALURE_STATUS, FAILURE, INVALID_WORK_REQUEST_STATUS
      );
      throw new IllegalStateException();
    }

    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    workRequestDTO.setStatus(WorkRequestStatusEnum.COMPLETED);
    final AddressDTO address = new AddressDTO();
    final AddressEntity addressEntity = entity.getAddress();

    address.setAddress(addressEntity.getAddress());
    address.setCity(addressEntity.getCity());
    address.setCountry(addressEntity.getCountry());
    address.setId(addressEntity.getId());

    workRequestDTO.setDescription(entity.getDescription());
    workRequestDTO.setWorkRequestId(entity.getId());
    workRequestDTO.setWorkType(entity.getWorkType());
    workRequestDTO.setAddress(address);

    loggerService.debug(LOG_API_CALL_STATUS, SUCCESS);

    return workRequestDTO;
  }
}
