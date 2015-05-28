/**
 *
 */
package jp.co.seattleconsulting.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import jp.co.seattleconsulting.dto.LoginDto;
import jp.co.seattleconsulting.service.TopService;
import net.arnx.jsonic.JSON;

import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

/**
 * TOP画面で行われる処理の制御を行うクラス.
 *
 * @author Endo
 */
public class TopAction {

	@Resource
	protected TopService topService;

	public LoginDto loginDto;

	public int countOfActive;
	public int countOfTalked;
	public int countOfNotTalked;
	public double parcentageOfTalked;
	public double parcentageOfNotTalked;

	/**
	 * TOP画面に遷移する.
	 *
	 * @return TOP画面のパス
	 */
	@Execute(validator = false)
	public String index() throws IOException {
		HttpServletResponse httpServletResponse = ResponseUtil.getResponse();
		httpServletResponse.setContentType("application/json");
		PrintWriter sendPoint = new PrintWriter(httpServletResponse.getOutputStream());

		sendPoint.println(JSON.encode(topService.getCountOfActive()));
		sendPoint.println(JSON.encode(topService.getCountOfTalked()));
		sendPoint.println(JSON.encode(topService.getCountOfNotTalked()));
		sendPoint.println(JSON.encode(topService.getParcentageOfTalked()));
		sendPoint.println(JSON.encode(100 - topService.getParcentageOfTalked()));
		sendPoint.flush();
		sendPoint.close();

		/**
		countOfActive = topService.getCountOfActive();
		countOfTalked = topService.getCountOfTalked();
		countOfNotTalked = topService.getCountOfNotTalked();
		parcentageOfTalked = topService.getParcentageOfTalked();
		parcentageOfNotTalked = 100 - topService.getParcentageOfTalked();
		**/

		return "top.jsp";
	}
}
