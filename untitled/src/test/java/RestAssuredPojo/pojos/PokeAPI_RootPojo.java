package RestAssuredPojo.pojos;

import lombok.*;
import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokeAPI_RootPojo {
    private PokeAPI_FirmnessPojo firmness;
    private ArrayList<PokeAPI_FlavorPojo> flavors;
    private int growth_time;
    private int id;
    private PokeAPI_ItemPojo item;
    private int max_harvest;
    private String name;
    private int natural_gift_power;
    private PokeAPI_NaturalGiftTypePojo natural_gift_type;
    private int size;
    private int smoothness;
    private int soil_dryness;
}
