package Java.Webest.Java.Webest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FurtherInformation {

    @NonNull
    private String paymentType;

    private int addressId;
}
