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

package chat.tamtam.botapi.client.impl;

import java.io.IOException;
import java.io.InputStream;

import org.jetbrains.annotations.Nullable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import chat.tamtam.botapi.client.TamTamSerializer;
import chat.tamtam.botapi.exceptions.SerializationException;

/**
 * @author alexandrchuprin
 */
public class JacksonSerializer implements TamTamSerializer {
    private final ObjectMapper mapper;

    public JacksonSerializer() {
        this(new ObjectMapper());
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
    }

    public JacksonSerializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Nullable
    @Override
    public byte[] serialize(Object object) throws SerializationException {
        if (object == null) {
            return null;
        }

        try {
            return mapper.writer().writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    @Nullable
    @Override
    public String serializeToString(@Nullable Object object) throws SerializationException {
        if (object == null) {
            return null;
        }

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }

    }

    @Nullable
    @Override
    public <T> T deserialize(String data, Class<T> responseType) throws SerializationException {
        if (data == null || data.isEmpty()) {
            return null;
        }

        try {
            ObjectReader reader = mapper.reader();
            JsonNode json = reader.readTree(data);
            return reader.treeToValue(json, responseType);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @Nullable
    @Override
    public <T> T deserialize(@Nullable InputStream data, Class<T> responseType) throws SerializationException {
        if (data == null) {
            return null;
        }

        try {
            return mapper.readValue(data, responseType);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @Nullable
    @Override
    public <T> T deserialize(@Nullable byte[] data, Class<T> responseType) throws SerializationException {
        if (data == null || data.length == 0) {
            return null;
        }

        try {
            return mapper.readValue(data, responseType);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
