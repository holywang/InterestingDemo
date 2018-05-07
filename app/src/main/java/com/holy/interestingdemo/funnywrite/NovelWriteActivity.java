package com.holy.interestingdemo.funnywrite;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovels;
import com.holy.interestingdemo.mainInfo.BaseActivity;
import com.holy.interestingdemo.utils.L;

public class NovelWriteActivity extends BaseActivity implements View.OnClickListener {

    public static final String TAG = "NovelWriteActivity";

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private TextView showSession, showContextNum;
    private EditText pageInput, contextInput;
    private Button addSessionBtn;

    private Intent data;


    private int contextNum;
    private String action;
    private boolean ifNone;
    private INovels novel;

    private String session, page;
    private StringBuilder context = new StringBuilder("");


    @Override
    public void toSetContentView() {
        setContentView(R.layout.activity_novel_write);
    }

    @Override
    public void initViews() {
        data = getIntent();
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.novel_write_save_fab);
        addSessionBtn = findViewById(R.id.novel_write_add_session);
        showSession = findViewById(R.id.novel_write_show_session);
        showContextNum = findViewById(R.id.novel_write_select_novel_text_size);
        pageInput = findViewById(R.id.novel_write_edit_page);
        contextInput = findViewById(R.id.novel_input_edit);
    }

    @Override
    public void setListener() {
        fab.setOnClickListener(this);
        contextInput.addTextChangedListener(watcher);
        addSessionBtn.setOnClickListener(this);
    }

    @Override
    public void doSth() {
        toolbar.setTitle("新章节编辑");
        setSupportActionBar(toolbar);
        novel = (INovels) data.getSerializableExtra("novel");
        action = data.getStringExtra("action");
        ifNone = data.getBooleanExtra("ifNone",false);
    }

    /**
     * Context的输入监听
     */

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            L.i(TAG, "字数" + count);

            if (count >= 10000) {
                Snackbar.make(contextInput, "极限了，一小节最多就能输入10000字", Snackbar.LENGTH_LONG).show();

                return;
            }

            if (9990 < count) {
                showContextNum.setTextColor(Color.RED);
            }
            contextNum = count;
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    };

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.novel_write_save_fab:
                break;
            case R.id.novel_write_add_session:
                break;
        }
    }
}
