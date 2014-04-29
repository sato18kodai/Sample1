package to.msn.wings.sample1;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

public class MainActivity extends Activity {

	private int targetLocalX;
	private int targetLocalY;

	private int screenX;
	private int screenY;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final OnTouchListener moving = new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO 自動生成されたメソッド・スタブ
				final ViewGroup.MarginLayoutParams params =
						(ViewGroup.MarginLayoutParams) v.getLayoutParams();


				//	絶対座標を取得
				int x = (int)event.getRawX();
				int y = (int) event.getRawY();

				switch(event.getAction()) {
				case MotionEvent.ACTION_DOWN:

					targetLocalX = params.leftMargin;
					targetLocalY = params.topMargin;

					screenX = x;
					screenY = y;

					break;

				case MotionEvent.ACTION_MOVE:

					int diffX = screenX - x;
					int diffY = screenY - y;

					targetLocalX -= diffX;
					targetLocalY -= diffY;

					v.layout(targetLocalX,
							targetLocalY,
							targetLocalX + v.getWidth(),
							targetLocalY + v.getWidth());

					screenX = x;
					screenY = y;

					break;

				}

				return true;
			}
		};


		findViewById(R.id.ImageView01).setOnTouchListener(moving);
		findViewById(R.id.ImageView02).setOnTouchListener(moving);

	}


}
