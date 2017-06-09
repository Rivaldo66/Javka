package Presentation_Layer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.CommonDialogs.ExtensionFilter;
import com.sun.glass.ui.CommonDialogs.FileChooserResult;
import com.sun.glass.ui.Cursor;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.Robot;
import com.sun.glass.ui.Screen;
import com.sun.glass.ui.Size;
import com.sun.glass.ui.Timer;
import com.sun.glass.ui.View;
import com.sun.glass.ui.Window;

import Logical_Layer.LogControler;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LOG extends Application {

	private JFrame frame1;
	private JPanel panel1;
	private JButton button1;
	private JLabel label1;
	private JTextField text1;
	private JLabel label2;
	private JTextField text2;

	public LOG() {

		frame1 = new JFrame();
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setSize(300, 400);
		frame1.setName("LOGOWANIE");

		panel1 = new JPanel(new GridBagLayout());
		panel1.setOpaque(false);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		frame1.setContentPane(new Background("LOGbackground.jpg"));

		c.gridx = 0;
		c.gridy = 0;
		label1 = new JLabel("User name: ");
		panel1.add(label1, c);

		c.gridx = 1;
		c.gridy = 0;
		text1 = new JTextField(15);
		panel1.add(text1, c);

		c.gridx = 0;
		c.gridy = 1;
		label2 = new JLabel("Password: ");
		panel1.add(label2, c);

		c.gridx = 1;
		c.gridy = 1;
		text2 = new JTextField(15);
		panel1.add(text2, c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.insets = new Insets(20, 0, 0, 0);
		button1 = new JButton("Zaloguj");
		

		
		panel1.add(button1, c);

		frame1.add(panel1);
	}
	



	public JFrame getFrame1() {
		return frame1;
	}

	public void setFrame1(JFrame frame1) {
		this.frame1 = frame1;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JTextField getText1() {
		return text1;
	}

	public void setText1(String string) {
		this.text1.setText(string); 
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public JTextField getText2() {
		return text2;
	}

	public void setText2(String string) {
		this.text2.setText(string);
	}

	@Override
	protected Object _enterNestedEventLoop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int _getKeyCodeForChar(char arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void _invokeAndWait(Runnable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void _invokeLater(Runnable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void _leaveNestedEventLoop(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean _supportsTransparentWindows() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean _supportsUnifiedWindows() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor createCursor(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cursor createCursor(int arg0, int arg1, Pixels arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixels createPixels(int arg0, int arg1, ByteBuffer arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixels createPixels(int arg0, int arg1, IntBuffer arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixels createPixels(int arg0, int arg1, IntBuffer arg2, float arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Robot createRobot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timer createTimer(Runnable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View createView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Window createWindow(long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Window createWindow(Window arg0, Screen arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void runLoop(Runnable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected FileChooserResult staticCommonDialogs_showFileChooser(Window arg0, String arg1, String arg2, String arg3,
			int arg4, boolean arg5, ExtensionFilter[] arg6, int arg7) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected File staticCommonDialogs_showFolderChooser(Window arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Size staticCursor_getBestSize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void staticCursor_setVisible(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int staticPixels_getNativeFormat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Screen[] staticScreen_getScreens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double staticScreen_getVideoRefreshPeriod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int staticTimer_getMaxPeriod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int staticTimer_getMinPeriod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int staticView_getMultiClickMaxX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int staticView_getMultiClickMaxY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected long staticView_getMultiClickTime() {
		// TODO Auto-generated method stub
		return 0;
	}

}
