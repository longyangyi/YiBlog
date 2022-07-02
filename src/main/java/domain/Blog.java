package domain;

public class Blog {

    private Integer id;
    private Integer senderid;
    private String content;
    private String time;
    private Integer replyto;//blog id

    private String senderNickname;
    private String receiverNickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getReplyto() {
        return replyto;
    }

    public void setReplyto(Integer replyto) {
        this.replyto = replyto;
    }

    public String getSenderNickname() {
        return senderNickname;
    }

    public void setSenderNickname(String senderNickname) {
        this.senderNickname = senderNickname;
    }

    public String getReceiverNickname() {
        return receiverNickname;
    }

    public void setReceiverNickname(String receiverNickname) {
        this.receiverNickname = receiverNickname;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", senderid=" + senderid +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", replyto=" + replyto +
                ", senderNickname='" + senderNickname + '\'' +
                ", receiverNickname='" + receiverNickname + '\'' +
                '}';
    }
}
