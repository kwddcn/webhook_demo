package spring_boot;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Hello {
	
	//ע�⣬�˴���д���ǣ�����������->webhook ���ֶ�Ӧ�� "������Ӧ��ID"
	private String myAppId="appId";
	//ע�⣬�˴���д���ǣ�����������->webhook ���ֶ�Ӧ�� "������Ӧ��Secret"
	private String myAppSecret="41db945e-c880-4737-a4ee-4c7b63a6d60e";

	@RequestMapping("/webhook")
	public String home(@RequestHeader Map<String, String> header, @RequestParam String eid,@RequestParam String eventType,
	@RequestParam String eventId) {
		String contentBody = "eid=" + eid+ "&eventType=" + eventType + "&eventId=" + eventId;
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
		SpringApplication.run(Hello.class, args);
	}
}
