package cn.edu.hust.bean;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;
@MessageDriven(mappedName = "personQueue")
public class MessageAlterHandler implements MessageListener{
    @Resource
    private MessageDrivenContext messageDrivenContext;

    @Override
    public void onMessage(Message message) {

    }
}
