package com.kodekonveyor.work_request.find;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestListDTO;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;
import com.kodekonveyor.work_request.WorkRequestUtil;
import com.kodekonveyor.work_request.WorkTypeEnum;
import com.kodekonveyor.work_request.create.CountryAndCityValidationUtil;

@RestController
public class FindWorkRequestController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @GetMapping("workRequest/{country}/{city}/{workType}")
  public WorkRequestListDTO call(
      final String country, final String city,
      final String workType
  ) {
    WorkTypeValidationUtil.validateWorkType(workType);
    CountryAndCityValidationUtil.validateCountry(country);

    CountryAndCityValidationUtil.validateCity(city);

    final List<WorkRequestEntity> entities = workRequestRepository
        .findByTypeAndCountryAndCity(WorkTypeEnum.valueOf(workType),
            country, city
        );
    final UserEntity currentUser = authenticatedUserService.call();

    final List<WorkRequestEntity> filteredList = new ArrayList<>();

    for (final WorkRequestEntity entity : entities)
      if (entity.getStatus().equals(WorkRequestStatusEnum.POSTED))
        filteredList.add(entity);
      else if (
        entity.getCustomer().getId() == currentUser.getId() ||
            entity.getProvider().getId() == currentUser.getId()
      )
        filteredList.add(entity);

    final WorkRequestListDTO dtoList = new WorkRequestListDTO();
    for (final WorkRequestEntity entity : filteredList) {
      final WorkRequestDTO dto = WorkRequestUtil
          .convertWorkRequestEntityToDTO(entity);
      dtoList.getRequests().add(dto);
    }
    return dtoList;
  }
}
