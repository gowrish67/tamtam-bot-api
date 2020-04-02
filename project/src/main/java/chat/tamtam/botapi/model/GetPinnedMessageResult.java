/*
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

package chat.tamtam.botapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.validation.Valid;

import org.jetbrains.annotations.Nullable;

/**
 * GetPinnedMessageResult
 */
public class GetPinnedMessageResult implements TamTamSerializable {

    @Nullable
    private @Valid Message message;

    public GetPinnedMessageResult message(@Nullable Message message) {
        this.setMessage(message);
        return this;
    }

    /**
    * Pinned message. Can be &#x60;null&#x60; if no message pinned in chat
    * @return message
    **/
    @Nullable
    @JsonProperty("message")
    public Message getMessage() {
        return message;
    }

    public void setMessage(@Nullable Message message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        GetPinnedMessageResult other = (GetPinnedMessageResult) o;
        return Objects.equals(this.message, other.message);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GetPinnedMessageResult{"
            + " message='" + message + '\''
            + '}';
    }
}
