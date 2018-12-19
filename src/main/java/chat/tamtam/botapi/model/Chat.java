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
import chat.tamtam.botapi.model.ChatStatus;
import chat.tamtam.botapi.model.ChatType;
import chat.tamtam.botapi.model.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import chat.tamtam.botapi.TamTamSerializable;
import org.jetbrains.annotations.Nullable;

/**
 * Chat
 */
public class Chat implements TamTamSerializable {
    @JsonProperty("chat_id")
    private final Long chatId;

    @JsonProperty("type")
    private final ChatType type;

    @JsonProperty("status")
    private final ChatStatus status;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("icon")
    private final Image icon;

    @JsonProperty("last_event_time")
    private final Long lastEventTime;

    @JsonProperty("participants_count")
    private final Integer participantsCount;

    @JsonProperty("owner_id")
    private Long ownerId;

    @JsonProperty("participants")
    private Map<String, Long> participants;

    @JsonCreator
    public Chat(@JsonProperty("chat_id") Long chatId, @JsonProperty("type") ChatType type, @JsonProperty("status") ChatStatus status, @JsonProperty("title") String title, @Nullable @JsonProperty("icon") Image icon, @JsonProperty("last_event_time") Long lastEventTime, @JsonProperty("participants_count") Integer participantsCount) { 
        this.chatId = chatId;
        this.type = type;
        this.status = status;
        this.title = title;
        this.icon = icon;
        this.lastEventTime = lastEventTime;
        this.participantsCount = participantsCount;
    }

    /**
    * Chats identifier
    * @return chatId
    **/
    public Long getChatId() {
        return chatId;
    }

    /**
    * Type of chat. One of: dialog, chat, channel
    * @return type
    **/
    public ChatType getType() {
        return type;
    }

    /**
    * Status of chat. One of: ACTIVE, REMOVED, LEFT of CLOSED
    * @return status
    **/
    public ChatStatus getStatus() {
        return status;
    }

    /**
    * Visible title of chat
    * @return title
    **/
    public String getTitle() {
        return title;
    }

    /**
    * Icon of chat
    * @return icon
    **/
    @Nullable
    public Image getIcon() {
        return icon;
    }

    /**
    * Time of last event occured in chat
    * @return lastEventTime
    **/
    public Long getLastEventTime() {
        return lastEventTime;
    }

    /**
    * Number of people in chat. Always 2 for &#x60;dialog&#x60; chat type
    * @return participantsCount
    **/
    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public Chat ownerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    /**
    * Identifier of chat owner. Visible only for chat admins
    * @return ownerId
    **/
    @Nullable
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Chat participants(Map<String, Long> participants) {
        this.participants = participants;
        return this;
    }

    public Chat putParticipantsItem(String key, Long participantsItem) {
        if (this.participants == null) {
            this.participants = new HashMap<String, Long>();
        }

        this.participants.put(key, participantsItem);
        return this;
    }

    /**
    * Participants in chat with time of last activity. Visible only for chat admins
    * @return participants
    **/
    @Nullable
    public Map<String, Long> getParticipants() {
        return participants;
    }

    public void setParticipants(Map<String, Long> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        Chat other = (Chat) o;
        return Objects.equals(this.chatId, other.chatId) &&
            Objects.equals(this.type, other.type) &&
            Objects.equals(this.status, other.status) &&
            Objects.equals(this.title, other.title) &&
            Objects.equals(this.icon, other.icon) &&
            Objects.equals(this.lastEventTime, other.lastEventTime) &&
            Objects.equals(this.participantsCount, other.participantsCount) &&
            Objects.equals(this.ownerId, other.ownerId) &&
            Objects.equals(this.participants, other.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, type, status, title, icon, lastEventTime, participantsCount, ownerId, participants);
    }

    @Override
    public String toString() {
        return "Chat{"
            + " chatId='" + chatId + '\''
            + " type='" + type + '\''
            + " status='" + status + '\''
            + " title='" + title + '\''
            + " icon='" + icon + '\''
            + " lastEventTime='" + lastEventTime + '\''
            + " participantsCount='" + participantsCount + '\''
            + " ownerId='" + ownerId + '\''
            + " participants='" + participants + '\''
            + '}';
    }
}

