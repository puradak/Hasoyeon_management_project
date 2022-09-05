이 프로그램은 미완성입니다.

프로그램 완성 목표
1. gui_table의 StudyTable의 setTable()에서 table의 ListSelectionListener에 구현된 코드 중, data의 Study의 String 필드가 아닌 String[] information으로 데이터를 불러오는 데, 이것을 String 필드로 바꾸기

2. gui_add의 AddMember를 해당 패키지의 다른 클래스처럼 깔끔하게 리팩터링 하기

3. gui_table의 StudyTable의 버튼 중 btn_edit, btn_remove의 기능을 구현하기
3-1. btn_edit은 선택된 row의 정보를 gui_add의 AddStudy에 그대로 복원하여 필요한 부분만 고쳐 수정함.
3-2. btn_remove는 해당 패키지의 MemberTable의 삭제 버튼과 동일한 기능을 가짐.

4. gui_table 패키지의 MemberTable의 수정버튼, 삭제버튼, 그리고 StudyTable의 삭제버튼을 눌렀을 때 수정 또는 삭제됨을 알려주는 작은 창을 현재 Table 프로그램 창의 중앙에 띄우기

5. data 패키지의 Member의 필드 중 ArrayList<String> study를 MemberTable에서 확인할 수 있도록 프로그램 수정하기

6. gui_table 패키지의 MemberTable, StudyTable의 정보를 액셀 파일로 변환하여 저장하기.

7. 데이터는 임의로 추가하고, 회장/부회장에게는 실제 멤버/스터디 데이터가 제공됩니다.