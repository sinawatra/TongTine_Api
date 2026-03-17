package wing.tongtin.demo.request;

import lombok.Data;
import wing.tongtin.demo.enumeration.KycDocumentType;

@Data
public class KycRequest {
    private String file;
    private KycDocumentType type;
}