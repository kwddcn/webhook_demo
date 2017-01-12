package spring_boot;

/**
 * erp��Ʒ����������webhook�ص�ʾ��
 */
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ReceiveEvent {
	
	//ע�⣬�˴���д���ǣ�����������->webhook ���ֶ�Ӧ�� "������Ӧ��ID"
	private String myAppId="926658455";
	//ע�⣬�˴���д���ǣ�����������->webhook ���ֶ�Ӧ�� "������Ӧ��Secret"
	private String myAppSecret="2ea077e0-15c9-49b9-8dba-95ef23a720b0";

	@RequestMapping("/webhookEvent")
	public String home(@RequestHeader Map<String, String> header, @RequestParam String eid,@RequestParam String eventType,
	@RequestParam String eventId,@RequestParam String createTime) {
		String contentBody = "eid=" + eid+ "&eventType=" + eventType + "&eventId=" + eventId+"&createTime="+createTime;
		if(WebHookUtil.checkAuth(myAppId, myAppSecret, contentBody, header)){
			System.out.println("���յ�һ���Ϸ����ͣ�����Ϊ�� "+contentBody);
			//�������͵��߼�д������
			//.....
		}else{
			System.out.println("���յ�һ���Ƿ�����");
			return "not ok";
		}
		
		return "ok";
	}

	public static void main(String[] args) {
		SpringApplication.run(ReceiveEvent.class, args);
	}
}
