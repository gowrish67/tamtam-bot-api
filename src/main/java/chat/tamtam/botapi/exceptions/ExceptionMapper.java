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

package chat.tamtam.botapi.exceptions;

import chat.tamtam.botapi.model.Error;

/**
 * @author alexandrchuprin
 */
public class ExceptionMapper {
    private ExceptionMapper() {
    }

    public static APIException map(int statusCode, Error error) {
        String message = error.getMessage();
        switch (statusCode) {
            case 404:
                return new NotFoundException(message);
            case 429:
                return new TooManyRequestsException(message);
        }

        switch (error.getCode()) {
            case "proto.payload":
                return new BadRequestException(message);
            case "attachment.not.ready":
                return new AttachmentNotReadyException();
            case "access.denied":
                return new AccessForbiddenException(message);
            case "chat.denied":
                if ("chat.send.msg.no.permission.because.not.admin".equals(message)) {
                    return new SendMessageForbiddenException(message);
                }
                return new ChatAccessForbiddenException(message);
        }

        return new APIException(statusCode, message);
    }
}
