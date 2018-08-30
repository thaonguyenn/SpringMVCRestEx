package web.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import web.model.Student;

@Repository
public class StudentDAO {
	private static List<Student> listStudent = new ArrayList<Student>();
	static {
		initEmps();
	}

	private static void initEmps() {
		Student st1 = new Student("", "");
		Student st2 = new Student("001", "Nguyen Van B");
		Student st3 = new Student("002", "Nguyen Van C");
		listStudent.add(st1);
		listStudent.add(st2);
		listStudent.add(st3);
	}

	public Student getStudent(String id) {
		int index = 0;
		for (int i = 1; i < listStudent.size(); i++) {
			if (id.equals(listStudent.get(i).getId())) {
				index = i;
				break;
			}
		}
		if(index==0) return null;
		return listStudent.get(index);
	}

	public Student addStudent(Student st) {
		listStudent.add(st);
		return st;
	}

	public Student updateStudent(Student st) {
		deleteStudent(st.getId());
		listStudent.add(st);
		return st;
	}

	public void deleteStudent(String id) {
		System.out.println(listStudent.size());
		int index = 0;
		for (int i = 1; i < listStudent.size(); i++) {
			if (id.equals(listStudent.get(i).getId())) {
				index = i;
				break;
			}
		}
		if(index!=0)
		listStudent.remove(index);
		System.out.println(listStudent.size());
	}
}
