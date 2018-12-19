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
import chat.tamtam.botapi.model.Chat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import chat.tamtam.botapi.TamTamSerializable;
import org.jetbrains.annotations.Nullable;

/**
 * ChatList
 */
public class ChatList implements TamTamSerializable {
    @JsonProperty("chats")
    private final List<Chat> chats;

    @JsonProperty("marker")
    private final Long marker;

    @JsonCreator
    public ChatList(@JsonProperty("chats") List<Chat> chats, @Nullable @JsonProperty("marker") Long marker) { 
        this.chats = chats;
        this.marker = marker;
    }

    /**
    * List of requested chats
    * @return chats
    **/
    public List<Chat> getChats() {
        return chats;
    }

    /**
    * Reference to the next page of requested chats
    * @return marker
    **/
    @Nullable
    public Long getMarker() {
        return marker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        ChatList other = (ChatList) o;
        return Objects.equals(this.chats, other.chats) &&
            Objects.equals(this.marker, other.marker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chats, marker);
    }

    @Override
    public String toString() {
        return "ChatList{"
            + " chats='" + chats + '\''
            + " marker='" + marker + '\''
            + '}';
    }
}

