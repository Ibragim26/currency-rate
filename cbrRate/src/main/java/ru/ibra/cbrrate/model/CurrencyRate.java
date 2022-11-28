package ru.ibra.cbrrate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
//@AllArgsConstructor(onConstructor = @_(@JsonCreator))
@AllArgsConstructor
@Builder
public class CurrencyRate {
    String numCode;
    String charCode;
    String nominal;
    String name;
    String value;
}
