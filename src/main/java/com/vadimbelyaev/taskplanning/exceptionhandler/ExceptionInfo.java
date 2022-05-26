package com.vadimbelyaev.taskplanning.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionInfo {

    private String message;

    private int code;
}
