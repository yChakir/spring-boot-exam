package org.cigma.springbootexam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchVo {

  private String contains;

  private String start;

  private String end;

}
