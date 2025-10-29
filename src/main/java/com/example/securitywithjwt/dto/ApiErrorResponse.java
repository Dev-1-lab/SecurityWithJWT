package com.example.securitywithjwt.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {

  private Integer status;
  private String message;
  private LocalDateTime timestamp;
 private String error;




}
