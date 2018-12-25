package chat.tamtam.botapi.model;

/*-
 * ------------------------------------------------------------------------
 * TamTam chat Bot API
 * ------------------------------------------------------------------------
 * Copyright (C) 2018 Mail.Ru Group
 * ------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ------------------------------------------------------------------------
 */

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import chat.tamtam.botapi.TamTamSerializable;
import org.jetbrains.annotations.Nullable;

/**
 * ContactAttachmentRequestPayload
 */
public class ContactAttachmentRequestPayload implements TamTamSerializable {
    @JsonProperty("name")
    private final String name;

    @JsonProperty("contactId")
    private final Long contactId;

    @JsonProperty("vcfInfo")
    private final String vcfInfo;

    @JsonProperty("vcfPhone")
    private final String vcfPhone;

    @JsonCreator
    public ContactAttachmentRequestPayload(@Nullable @JsonProperty("name") String name, @Nullable @JsonProperty("contactId") Long contactId, @Nullable @JsonProperty("vcfInfo") String vcfInfo, @Nullable @JsonProperty("vcfPhone") String vcfPhone) { 
        this.name = name;
        this.contactId = contactId;
        this.vcfInfo = vcfInfo;
        this.vcfPhone = vcfPhone;
    }

    /**
    * Contact name
    * @return name
    **/
    @Nullable
    public String getName() {
        return name;
    }

    /**
    * Contact identifier
    * @return contactId
    **/
    @Nullable
    public Long getContactId() {
        return contactId;
    }

    /**
    * Full information about contact in VCF format
    * @return vcfInfo
    **/
    @Nullable
    public String getVcfInfo() {
        return vcfInfo;
    }

    /**
    * Contact phone in VCF format
    * @return vcfPhone
    **/
    @Nullable
    public String getVcfPhone() {
        return vcfPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        ContactAttachmentRequestPayload other = (ContactAttachmentRequestPayload) o;
        return Objects.equals(this.name, other.name) &&
            Objects.equals(this.contactId, other.contactId) &&
            Objects.equals(this.vcfInfo, other.vcfInfo) &&
            Objects.equals(this.vcfPhone, other.vcfPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contactId, vcfInfo, vcfPhone);
    }

    @Override
    public String toString() {
        return "ContactAttachmentRequestPayload{"
            + " name='" + name + '\''
            + " contactId='" + contactId + '\''
            + " vcfInfo='" + vcfInfo + '\''
            + " vcfPhone='" + vcfPhone + '\''
            + '}';
    }
}
