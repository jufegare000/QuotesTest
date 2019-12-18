
package com.quotes.quotes;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "quotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "All details about the quotes. ")
public class Quote {
@ApiModelProperty(notes = "The database generated quote ID")
@Id
private String id;
@ApiModelProperty(notes = "quote text")
private @NonNull String text;
@ApiModelProperty(notes = "image url")
private @NonNull String url;

}

