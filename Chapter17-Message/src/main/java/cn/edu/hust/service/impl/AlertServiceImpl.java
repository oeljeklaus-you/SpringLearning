package cn.edu.hust.service.impl;

import cn.edu.hust.bean.Person;
import cn.edu.hust.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class AlertServiceImpl implements AlertService {
    @Autowired
    private JmsTemplate jmsTemplate;
    //当调用send()方法时,JmsTemplate将负责JSM连接、会话代表发送者发送消息
    @Override
    public void sendPersonAlertService(final Person person) {
        //指定目的地名称
        jmsTemplate.convertAndSend(person);
    }

    public Person receive()
    {
        return (Person) jmsTemplate.receiveAndConvert();
    }
}
