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
import chat.tamtam.botapi.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import chat.tamtam.botapi.TamTamSerializable;
import org.jetbrains.annotations.Nullable;

/**
 * ContactAttachmentPayload
 */
public class ContactAttachmentPayload implements TamTamSerializable {
    @JsonProperty("vcfInfo")
    private final String vcfInfo;

    @JsonProperty("tamInfo")
    private final User tamInfo;

    @JsonCreator
    public ContactAttachmentPayload(@Nullable @JsonProperty("vcfInfo") String vcfInfo, @Nullable @JsonProperty("tamInfo") User tamInfo) { 
        this.vcfInfo = vcfInfo;
        this.tamInfo = tamInfo;
    }

    /**
    * User info in VCF format
    * @return vcfInfo
    **/
    @Nullable
    public String getVcfInfo() {
        return vcfInfo;
    }

    /**
    * User info
    * @return tamInfo
    **/
    @Nullable
    public User getTamInfo() {
        return tamInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        ContactAttachmentPayload other = (ContactAttachmentPayload) o;
        return Objects.equals(this.vcfInfo, other.vcfInfo) &&
            Objects.equals(this.tamInfo, other.tamInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vcfInfo, tamInfo);
    }

    @Override
    public String toString() {
        return "ContactAttachmentPayload{"
            + " vcfInfo='" + vcfInfo + '\''
            + " tamInfo='" + tamInfo + '\''
            + '}';
    }
}
