package com.kodekonveyor.work_request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kodekonveyor.authentication.UserEntity;

import lombok.Data;

@Entity
@Data
public class WorkRequestEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private UserEntity customer;
  private String workType;

  private AddressEntity address;
  private String description;
  private WorkRequestStatusEnum status;

}
