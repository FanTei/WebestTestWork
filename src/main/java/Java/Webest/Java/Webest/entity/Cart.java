package Java.Webest.Java.Webest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data

public class Cart {
    private DTOItem[] items;

    private FurtherInformation furtherInformation;


}
