package com.example.myapplication.Lab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class M002ScreenDanhSachTruyen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_m002_screen_danh_sach_truyen, container, false);
        RecyclerView rvStories = view.findViewById(R.id.rvStories);
        ImageView imgBack = view.findViewById(R.id.imgBack);
        TextView tvTopicTitle = view.findViewById(R.id.tvTopicTitle);


        rvStories.setLayoutManager(new LinearLayoutManager(getContext()));
        String topicName = getArguments() != null ? getArguments().getString("TOPIC_NAME") : "";
        tvTopicTitle.setText(topicName);
        imgBack.setOnClickListener(v -> {
            ((TruyenCuoiActivity) getActivity()).backToM001Screen();
        });
        String[] stories;
        String[] storyContents;

        switch (topicName) {
            case "Chú vịt vàng - thánh gây họa của ao làng":
                stories = new String[]{
                        "Vịt Vàng làm anh hùng… nhưng cứu nhầm",
                        "Bài tập thể dục buổi sáng làm… vỡ bờ ao",
                        "Vịt Vàng muốn làm người mẫu",
                        "Buổi diễn thuyết không ai mời",
                        "Vịt Vàng chơi trốn tìm rồi ngủ quên",
                        "Cố gắng làm ca sĩ nhưng thành báo động thiên tai",
                        "Đại chiến bánh mì thần thánh",
                        "Màn thử nghiệm bay thất bại mỹ mãn",
                        "Thử làm thám tử",
                        "Vịt Vàng thử làm TikToker"};
                storyContents = new String[]{
                        "Vịt Vàng nghe tiếng “cứu với!” liền tung cánh lao đến, nhưng sau đó mới phát hiện tiếng đó là… ếch đang tập hát opera. Hóa ra cứu nhầm, làm cả ao cười nghiêng ngả.",

                        "Chú Vịt Vàng quyết định tập thể dục bằng cách nhảy belly dance trên bờ. Nhảy quá sung, đất sụp xuống làm nước tràn từ ao nhỏ sang ao lớn, cá với vịt hỗn loạn như đại náo giang hồ.",

                        "Thấy mọi người khen lông mình vàng óng, chú quyết định “catwalk” trên bờ ao. Nhưng đường catwalk là cây tre tròn trơn → trượt một phát xuống nước, tạo sóng thần mini làm ướt hết quần áo của bác Nông Dân.",

                        "Vịt Vàng leo lên tảng đá, hô hào: “Tôi sẽ dạy mọi người cách bơi nhanh!”. Nhưng chú… bơi chậm nhất ao. Đang diễn thuyết thì bị cá chép bơi ngang qua phóng sóng làm rớt xuống, mất luôn uy tín.",

                        "Cả ao đi tìm mãi không thấy. Cuối cùng phát hiện chú đang trốn trong… cái chum và ngủ say sưa. Cả ao tưởng mất tích, phải tổ chức cuộc họp tìm vịt.",

                        "Chú quyết tâm luyện giọng, đứng hát trên bờ ao. Giọng to quá khiến đàn gà tưởng có báo động thiên tai, chạy tán loạn. Bác Nông Dân tưởng lũ về, vội lấy bao cát đắp bờ.",

                        "Bác Nông Dân ném một miếng bánh mì xuống ao. Vịt Vàng tưởng báu vật trời cho, xông vào giành, làm lật cả bè rau muống, té luôn vào đầu cá rô khiến nó tức giận rượt cả ao.",

                        "Chú nghĩ: “Thiên nga bay được, mình cũng bay được!”. Vịt Vàng trèo lên cành cây, dang cánh rồi nhảy xuống, đáp ngay vào chậu nước mới giặt của bác gái. Cả ao bị phạt lao động công ích.",

                        "Vịt Vàng thấy quả ổi bị mất, nghi ngờ từ chim sâu đến cá trê. Sau 2 giờ điều tra, chú mới nhớ ra… chính mình ăn hôm qua nhưng quên mất. Pha tự phá án kinh điển khiến cả ao cười lăn.",

                        "Chú muốn quay video “Vịt Vàng làm điều phi thường”, nên nhảy lên lá sen để quay trend. Lá sen không chịu nổi, rách đôi → chú chìm lỉm, cả ao nghe tiếng “PỤP” vang dội, viral ngay lập tức."
                };
                break;

            default:
                stories = new String[]{"Không có truyện nào"};
                storyContents = new String[]{"Không có nội dung"};
        }
        // Khởi tạo Adapter và xử lý khi click vào 1 truyện
        StoryAdapter adapter = new StoryAdapter(stories, position -> {
            Bundle bundle = new Bundle();
            bundle.putString("TOPIC_NAME", topicName);
            bundle.putInt("STORY_INDEX", position);
            bundle.putStringArray("STORY_TITLES", stories);
            bundle.putStringArray("STORY_CONTENTS", storyContents);
            M003ScreenDocTruyen frg = new M003ScreenDocTruyen();
            frg.setArguments(bundle);

            ((TruyenCuoiActivity) getActivity()).showFrg(frg);
        });

        rvStories.setAdapter(adapter);

        return view;
    }
}
