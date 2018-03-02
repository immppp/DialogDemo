package qaq.myapplication.demo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import qaq.myapplication.R;
import qaq.myapplication.ScreenSizeUtils;

/**
 * Created by qaq on 2018/3/2.
 */

public class clickOne {

    Context mContext;
    private AlertDialog dialog;
    //设置列表对话框的数据
    String[] item = {"列表一", "列表二", "列表三"};
    //设置多选的属性
    final boolean checkedItems[] = {true, false, true};

    public clickOne(Context context) {
        mContext = context;
    }

    //定义不同的对话框方法
    public void setDialog(int mPositon) {
        if (mPositon == 1) {
            //执行简单的对话框
            dialog1();
        } else if (mPositon == 2) {
            dialog2();
        } else if (mPositon == 3) {
            dialog();
        } else if (mPositon == 4) {
            dialog4();
        } else if (mPositon == 5) {
            dialog5();
        } else if (mPositon == 6) {
            dialog6();
        }else if (mPositon == 7) {
            dialog7();
        }else if (mPositon == 8) {
            dialog8();
        }
        //设置点击对话框外部不让对话框消失
        dialog.setCanceledOnTouchOutside(false);

    }

    private void dialog8(){

        final ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMessage("正在加载中");
        dialog.setMax(100);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int progress = 0;
            @Override
            public void run() {
                dialog.setProgress(progress += 5);
                if (progress == 100) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
        dialog.show();
    }

    //圆形对话框
    private void dialog7() {
        ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setTitle("加载信息");
        dialog.setMessage("您请求了一个不存在的消息！");
        dialog.show();
    }

    public Dialog dialog_cut;
    //全部自定义对话框
    private void dialog6() {
        dialog_cut = new Dialog(mContext, R.style.NormalDialogStyle);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom, null);
        Button take_pic = view.findViewById(R.id.take_picture);
        Button pic = view.findViewById(R.id.picture);
        Button cancel = view.findViewById(R.id.cancel);
        dialog_cut.setContentView(view);
        //使得点击对话框外部不消失对话框
        dialog_cut.setCanceledOnTouchOutside(false);
        //设置对话框的大小
        view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(mContext).getScreenHeight() * 0.23f));
        Window dialogWindow = dialog_cut.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(mContext).getScreenWidth() * 0.9f);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        dialogWindow.setAttributes(lp);
        dialog_cut.show();

        //设置button的点击事件
        take_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "拍照", Toast.LENGTH_SHORT).show();
                dialog_cut.dismiss();
            }
        });
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "相册", Toast.LENGTH_SHORT).show();
                dialog_cut.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
                dialog_cut.dismiss();
            }
        });

    }

    //半自定义布局
    private void dialog5() {
        //自定义一个需要的布
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_custom, null);
        final EditText text = view.findViewById(R.id.text);

        dialog = new AlertDialog.Builder(mContext).
                setIcon(R.drawable.ic_launcher_background).
                setTitle("自定义对话框1")
                .setView(view)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String s = text.getText().toString();
                        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();

    }

    //多选对话框
    private void dialog4() {
        dialog = new AlertDialog.Builder(mContext).
                setIcon(R.drawable.ic_launcher_background).
                setTitle("列表对话框")
                .setMultiChoiceItems(item, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        Toast.makeText(mContext, "点击的第" + i + "个对话框", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "确认", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

    //单选对话框
    private void dialog() {
        dialog = new AlertDialog.Builder(mContext).
                setIcon(R.drawable.ic_launcher_background).
                setTitle("列表对话框")
                .setSingleChoiceItems(item, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "点击的第" + i + "个对话框", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "确认", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

    //简单对话框
    private void dialog1() {
        dialog = new AlertDialog.Builder(mContext).setIcon(R.drawable.ic_launcher_background)
                .setTitle("简单的对话框！").setMessage("一个非常简单的对话框")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "确认", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        //一定要show一下
        dialog.show();
    }

    //列表对话框
    private void dialog2() {
        dialog = new AlertDialog.Builder(mContext).
                setIcon(R.drawable.ic_launcher_background).
                setTitle("列表对话框")
                .setItems(item, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "点击的第" + i + "个对话框", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "确认", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

}
