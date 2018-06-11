package youchat;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
 
// class dat creates the list
public class MyFriends extends JPanel
{
	private JLabel label;
	protected JList list;
        public JFrame parent;
	public MyFriends(JFrame parent, String[] Names, int cat)
	{      
            Box box = new Box(BoxLayout.Y_AXIS);
            Font style = new Font("Times New Roman",Font.PLAIN,16);
            Font title = new Font("Times New Roman",Font.BOLD,20);
            this.parent = parent;
            if(cat==1)
            {
               JLabel online = new JLabel ("Online Friends");
               online.setForeground(Color.GREEN);
               online.setFont(title);
               box.add(online);
            }
            else if(cat ==0)
            {
                JLabel offline = new JLabel("Offline Friends");
                offline.setFont(title);
                offline.setForeground(Color.RED);
                box.add(offline);
            }
            else if(cat==-1)
            {
                JLabel offline = new JLabel("Friends");
                offline.setFont(title);
                offline.setForeground(Color.RED);
                box.add(offline);
            }
					
		list = new JList(Names);
                list.setPreferredSize(new Dimension(401,322));
                list.setFont(style);
                list.setForeground(Color.black);
                list.setBackground(Color.LIGHT_GRAY);
		list.addListSelectionListener(new ListSelectionListener(){
                
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    
                    String user = (String)list.getSelectedValue();
                    if(user != null){
                    String []conts = user.split(":");
                    String username = conts[1].trim();
                     YouChatMain y = (YouChatMain)MyFriends.this.parent;
                      String cur_user = y.verified.username;             
                     new MessageSender(MyFriends.this.parent,cur_user,username);
                    }
                }
                });
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		box.add(new JScrollPane(list));
                add(box);
		setBackground(Color.white);
	}
}


	

