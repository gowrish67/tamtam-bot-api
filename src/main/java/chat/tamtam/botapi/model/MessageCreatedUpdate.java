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
import chat.tamtam.botapi.model.Message;
import chat.tamtam.botapi.model.Update;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import chat.tamtam.botapi.TamTamSerializable;
import org.jetbrains.annotations.Nullable;

/**
 * You will get this &#x60;update&#x60; as soon as message is created
 */
public class MessageCreatedUpdate extends Update implements TamTamSerializable {
    @JsonProperty("message")
    private final Message message;

    @JsonCreator
    public MessageCreatedUpdate(@JsonProperty("message") Message message, @JsonProperty("timestamp") Long timestamp) { 
        super(timestamp);
        this.message = message;
    }

    /**
    * Newly created message
    * @return message
    **/
    public Message getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        MessageCreatedUpdate other = (MessageCreatedUpdate) o;
        return Objects.equals(this.message, other.message) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, super.hashCode());
    }

    @Override
    public String toString() {
        return "MessageCreatedUpdate{"+ super.toString()
            + " message='" + message + '\''
            + '}';
    }
}
