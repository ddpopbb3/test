package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.domain.OrderDetail;
import com.spring.service.ContactinfoService;
import com.spring.service.OrderlineService;
import com.spring.service.OrdersService;
import com.spring.service.ProductService;
import com.spring.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestMybatis {

	@Autowired
	@Qualifier("UserService")
	private UserService userService;
	
	@Autowired
	@Qualifier("ProductService")
	private ProductService productservice;
	
	@Autowired
	@Qualifier("ContactService")
	private ContactinfoService contactinfoService;
	
	@Autowired
	@Qualifier("OrdersService")
	private OrdersService ordersservice;
	
	@Autowired
	@Qualifier("OrderlineService")
	private OrderlineService orderlineservice;
	
	
//	//User测试
//	@Test
//	public void TestUserSelect() {
//		User user = userService.selectByPrimaryKey(1);
//		System.out.println(user.getName());
//		assertEquals(user.getName(), "111");
//	}
//	
//	@Test
//	public void TestUserInsert() {
//		User user = new User();
//		user.setName("12312");
//		user.setPassword("fasdf3");
//		int i = userService.insert(user);
//		System.out.println(i);
//		assertEquals(i, 1);
//	}
//	

//
//	@Test
//	public void TestUserLogin() {
//		String string = new String("111");
//		User user = userService.selectByName(string);
//		System.out.println(user.getUserid());
//		assertEquals(user.getUserid(), Integer.valueOf(1));
//	}
//
//	@Test
//	public void TestHasmatch() {
//		LoginCommand loginCommand = new LoginCommand();
//		loginCommand.setName("111");
//		loginCommand.setPassword("111");
//		boolean match = userService.hasMatchUser(loginCommand);
//		assertEquals(match, true);
//	}
//  //Product测试
//	@Test
//	public void TestProductSelect() {
//		Product product = new Product();
//		product = productservice.selectByPrimaryKey(Long.valueOf(1));
//		System.out.println(product.toString());
//		assertEquals(product.getCategoryid(), Long.valueOf(1));
//	}
//	
//	@Test
//	public void TestProductList() {
//		ArrayList<Product> list = new ArrayList<Product>();
//		list = (ArrayList<Product>) productservice.getAll();
//		for(Product product :list){
//			System.out.println(product.toString());
//		}
//	}
	
//	//Contacinfo测试
//	@Test
//	public void TestContactSelect() {
//		Contactinfo contactinfo = new Contactinfo();
//		contactinfo = contactinfoService.selectByPrimaryKey(1);
//		System.out.println(contactinfo.toString());
//		assertEquals(contactinfo.getUserid(), Integer.valueOf(1));
//	}
//	
//	@Test
//	public void TestContactList() {
//		ArrayList<Contactinfo> list = new ArrayList<Contactinfo>();
//		list = (ArrayList<Contactinfo>) contactinfoService.getAll();
//		for(Contactinfo contactinfo :list){
//			System.out.println(contactinfo.toString());
//		}
//	}
//	
//	@Test
//	public void TestContactSelectByUserid() {
//		Contactinfo contactinfo = new Contactinfo();
//		contactinfo = contactinfoService.selectByUserid(1);
//		System.out.println(contactinfo.toString());
//		assertEquals(contactinfo.getUserid(), Integer.valueOf(1));
//	}
	
	//Orders测试
//	@Test
//	public void TestOrdersInsert() {
//		Orders orders = new Orders();
//		orders.setCost(BigDecimal.valueOf(1));
//		orders.setName("dsf");
//		orders.setPaywayid(Short.valueOf((short) 1));
//		orders.setStatusid(Short.valueOf((short) 1));
//		orders.setUserid(Integer.valueOf(1));
//		int i = ordersservice.insertOrders(orders);
//		System.out.println(i);
//		assertEquals(i, 1);
//	}
//	@Test
//	public void TestCountOrder(){
//		int userid = 1;
//		int m = ordersservice.count(1);
//		System.out.println(m);
//	}
	
//	@Test
//	public void TestListOrder(){
//		int userid = 1;
//		List<Orders> list = ordersservice.getAll(userid);
//		for(Orders s:list)
//			System.out.println(s.getName()+s.getUserid());
//	}
	//Ordrerline测试
//	@Test
//	public void TestOrderline(){
//		int lineid = 1;
//		Orderline orderline = orderlineservice.selectByPrimaryKey(lineid);
//		System.out.println(orderline.getAmount());
//	}
	
	@Test
	public void TestListOrder(){
		List<OrderDetail> list = ordersservice.getorderDetail(16, 9);
		for(OrderDetail s:list)
			System.out.println(s.getProductname()+s.getUserid());
	}
}
