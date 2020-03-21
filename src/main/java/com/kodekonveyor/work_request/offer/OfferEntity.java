package com.kodekonveyor.work_request.offer;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.work_request.WorkRequestEntity;

import lombok.Data;

@Data
public class OfferEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long price;
  private WorkRequestEntity workRequest;
  private UserEntity provider;
}
