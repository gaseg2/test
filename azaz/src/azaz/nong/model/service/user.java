package azaz.nong.model.service;

import azaz.nong.model.userDTO;

import java.util.List;
import java.util.Map;

import azaz.nong.model.SellDTO;

public interface user {
	public void insertUser(userDTO dto) throws Exception;		//ȸ�� ����
	public void insertUser2(userDTO dto) throws Exception;		//ȸ�� ����
	public int userCheck(userDTO dto) throws Exception;			//�α��� üũ
	public int userDelete(userDTO dto) throws Exception;		//ȸ�� Ż��
	public int confirmId(userDTO dto) throws Exception;			//���̵� Ȯ��
	public userDTO getUser(String ID) throws Exception;
	public void updateUser (userDTO dto) throws Exception;		//������ ����
	public void updateUser2 (userDTO dto) throws Exception;		//������ ����
	public userDTO searchId(String phone) throws Exception;
	public userDTO searchMap(String business_name) throws Exception;
	public userDTO searchPw(userDTO dto) throws Exception;
	public List selectWriter() throws Exception;
	public List<SellDTO> mainList() throws Exception;
}
