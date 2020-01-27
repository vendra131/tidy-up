package com.kodekonveyor.work_request.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.work_request.WorkRequestRepository;

@RestController
public class GiveofferController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @PostMapping("/offer")
  public void
      call(@RequestBody final OfferDTO offerDTO) {
    OfferValidationUtil.inputValidation(workRequestRepository, offerDTO);
  }

}
