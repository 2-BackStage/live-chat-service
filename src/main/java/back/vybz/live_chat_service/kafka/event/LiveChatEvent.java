package back.vybz.live_chat_service.kafka.event;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LiveChatEvent {

    private String liveId;
    private String senderUuid;
    private String nickname;
    private String content;

    @Builder
    public LiveChatEvent(String liveId, String senderUuid, String nickname, String content) {
        this.liveId = liveId;
        this.senderUuid = senderUuid;
        this.nickname = nickname;
        this.content = content;
    }

}
