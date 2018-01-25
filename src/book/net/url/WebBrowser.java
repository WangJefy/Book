package book.net.url;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         WebBrowser
 * 创建时间： 2018年1月22日上午8:58:49
 * 修改人：     Jefy
 * 类描述：     实现一个Web浏览器。支持HTML和HTM页面显示。使用JEditorPane组件
 */
public class WebBrowser extends JFrame implements HyperlinkListener,PropertyChangeListener{

	/**
	 * 序列化对象
	 */
	private static final long serialVersionUID = -572765997822736217L;

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
