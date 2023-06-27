package RestAssuredPojo.pojos;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// burada @Getter @Setter ve @ToString notasyonları yerine sadece @Data notasyonu kullanılabilirdi.
public class PokeAPI_FirmnessPojo {
    private String name;
    private String url;
}
