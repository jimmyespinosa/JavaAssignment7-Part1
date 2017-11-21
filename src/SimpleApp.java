import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import java.awt.Color;

public class SimpleApp {

	private JFrame frame;
	private JTextField txtHelloGuiWorld;
	private JLabel statusBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleApp window = new SimpleApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		txtHelloGuiWorld = new JTextField();
		txtHelloGuiWorld.setVisible(false);
		txtHelloGuiWorld.setForeground(Color.BLUE);
		txtHelloGuiWorld.setCaretColor(Color.BLACK);
		txtHelloGuiWorld.setText("Hello GUI World!");
		frame.getContentPane().add(txtHelloGuiWorld);
		txtHelloGuiWorld.setColumns(10);
		
		//adding status bar to display our future clicks
		statusBar = new JLabel("default");
		frame.getContentPane().add(statusBar);
		
		HandlerForMouse handler = new HandlerForMouse();
		frame.addMouseListener(handler);
		frame.addMouseMotionListener(handler);
		
		

		// Create the JButton
		JButton btnNewButton = new JButton("Click Me!");
		frame.getContentPane().add(btnNewButton);

		// adding the listener
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHelloGuiWorld.setVisible(true);
			}
		});

	}
	
	private class HandlerForMouse implements MouseListener, MouseMotionListener {
		
		public void mouseClicked(MouseEvent event) {
			txtHelloGuiWorld.setVisible(true);
			statusBar.setText(String.format("Clicked at %d %d", event.getX(), event.getY()));
		}
		
		public void mousePressed(MouseEvent event) {
			statusBar.setText("You pressed down the mouse");
		}
		
		public void mouseReleased(MouseEvent event) {
			statusBar.setText("You released the button");
		}
		
		public void mouseEntered(MouseEvent event) {
			statusBar.setText("You have entered the area");
		}
		
		public void mouseExited(MouseEvent event) {
			statusBar.setText("Mouse no longer detected");
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			statusBar.setText("Mouse has been dragged across the frame");
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			statusBar.setText("MOUSEISMOVING!!!!!!!!!!!!!!");	
		}
		
		
		
	}
}

