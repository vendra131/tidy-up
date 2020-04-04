package com.kodekonveyor.work_request;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kodekonveyor.authentication.UserEntity;

public interface WorkRequestRepository
    extends CrudRepository<WorkRequestEntity, Long> {

  List<WorkRequestEntity> findByCustomer(UserEntity user);

  List<WorkRequestEntity> findByWorkRequestId(Long workRequestId);

  List<WorkRequestEntity> findByTypeAndCountryAndCity(
      WorkTypeEnum workType,
      String country, String city
  );

}
