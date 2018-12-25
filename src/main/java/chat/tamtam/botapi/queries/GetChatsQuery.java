package chat.tamtam.botapi.queries;

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

import chat.tamtam.botapi.client.TamTamClient;

import chat.tamtam.botapi.model.ChatList;
import chat.tamtam.botapi.queries.GetChatsQuery;

public class GetChatsQuery extends TamTamQuery<ChatList> {
    private final QueryParam<Integer> count = new QueryParam<Integer>("count", this);
    private final QueryParam<Long> marker = new QueryParam<Long>("marker", this);

    public GetChatsQuery(TamTamClient client) {
        super(client, "/me/chats", null, ChatList.class, Method.GET);
    }

    public GetChatsQuery count(Integer value) {
        this.count.setValue(value);
        return this;
    }
    public GetChatsQuery marker(Long value) {
        this.marker.setValue(value);
        return this;
    }
}