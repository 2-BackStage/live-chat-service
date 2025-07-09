package back.vybz.live_chat_service.live_chat.dto.response;

import back.vybz.live_chat_service.kafka.event.LiveChatEvent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseLiveChatDto {

    private String senderUuid;
    private String nickname;
    private String content;

    @Builder
    public ResponseLiveChatDto(String senderUuid, String nickname, String content) {
        this.senderUuid = senderUuid;
        this.nickname = nickname;
        this.content = content;
    }

    public static ResponseLiveChatDto from(LiveChatEvent liveChatEvent) {
        return ResponseLiveChatDto.builder()
                .senderUuid(liveChatEvent.getSenderUuid())
                .nickname(liveChatEvent.getNickname())
                .content(liveChatEvent.getContent())
                .build();
    }

}
