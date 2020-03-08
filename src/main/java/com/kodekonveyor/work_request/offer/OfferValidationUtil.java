package com.kodekonveyor.work_request.offer;

import java.util.List;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class OfferValidationUtil {

  public static void inputValidation(
      final WorkRequestRepository workRequestRepository, final OfferDTO offerDTO
  ) {
    validatePrice(offerDTO);
    validateWorkRequestId(workRequestRepository, offerDTO);
  }

  public static void validatePrice(final OfferDTO offerDTO) {
    if (offerDTO.getPrice() < WorkRequestConstants.MIN_PRICE)
      throw new ValidationException(WorkRequestConstants.INVALID_PRICE);
  }

  private static void validateWorkRequestId(
      final WorkRequestRepository workRequestRepository, final OfferDTO offerDTO
  ) {

    final int workId = 0;
    final long workRequestId = offerDTO.getWorkRequestId();

    if (workRequestId <= workId)
      throw new ValidationException(
          WorkRequestConstants.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION
      );

    final List<WorkRequestEntity> workRequestEntity =
        workRequestRepository.findByWorkRequestId(workRequestId);
    if (workRequestEntity.isEmpty())
      throw new ValidationException(
          WorkRequestConstants.INVALID_WORK_REQUEST_ID_EXCEPTION
      );

  }

}
