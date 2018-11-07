package chat.tamtam.api.objects.attachment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author alexandrchuprin
 */
public class TTFileAttachment extends TTAttachment {
    private final Payload payload;

    public TTFileAttachment(String url) {
        this.payload = new Payload(url);
    }

    @JsonCreator
    public TTFileAttachment(@JsonProperty(PAYLOAD) Payload payload) {
        this.payload = payload;
    }

    @Override
    protected TTAttachmentPayload getPayload() {
        return payload;
    }

    private class Payload implements TTAttachmentPayload {
        @JsonProperty("url")
        private final String url;

        private Payload(String url) {
            this.url = url;
        }
    }
}
