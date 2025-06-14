package chat.blubbai.backend.model;

import chat.blubbai.backend.utils.PhoneUtility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "phone_number")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pnId;
    private String country;
    private String number;

    /**
     * Get the full phone number in E.164 format.
     * @return String in the format "+[country_code][Number]"
     */
    @JsonIgnore
    @Transient
    public String getFullNumber() {
        return "+" + PhoneUtility.getCountryCodeNumber(country) + number;
    }

   }
