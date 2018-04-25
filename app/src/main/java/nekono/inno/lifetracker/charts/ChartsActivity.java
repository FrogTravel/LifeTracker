package nekono.inno.lifetracker.charts;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.threeten.bp.Duration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.model.Model;
import nekono.inno.lifetracker.model.Task;

public class ChartsActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 3, 22);
        Date date = calendar.getTime();
        new Task("name1", "category1", "", "", calendar.getTime(), calendar.getTime(), Duration.ofHours(1));
        calendar.set(2018, 3, 22);
        new Task("name2", "category1", "", "", calendar.getTime(), calendar.getTime(), Duration.ofHours(2));
        calendar.set(2018, 3, 24);
        new Task("name3", "category2", "", "", calendar.getTime(), calendar.getTime(), Duration.ofHours(3));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_charts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;
            ArrayList<Integer> colors = new ArrayList<Integer>();
            for (int c : ColorTemplate.VORDIPLOM_COLORS)
                colors.add(c);
            for (int c : ColorTemplate.JOYFUL_COLORS)
                colors.add(c);
            for (int c : ColorTemplate.COLORFUL_COLORS)
                colors.add(c);
            for (int c : ColorTemplate.LIBERTY_COLORS)
                colors.add(c);
            for (int c : ColorTemplate.PASTEL_COLORS)
                colors.add(c);
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 0:
                    rootView = inflater.inflate(R.layout.category_chart, container, false);
                    PieChart pieChart = rootView.findViewById(R.id.category_chart);
                    List<PieEntry> entries = new ArrayList<>();
                    HashMap<String, Integer> dictionary = ChartsPresenter.getTaskCountByCategory();
                    for (String key :
                            dictionary.keySet()) {
                        entries.add(new PieEntry(dictionary.get(key), key));
                    }
                    PieDataSet pieDataSet = new PieDataSet(entries, "Categories");
                    pieDataSet.setColors(colors);
                    PieData pieData = new PieData(pieDataSet);
                    //pieData.setValueFormatter(new PercentFormatter());
                    pieData.setValueTextSize(11f);
                    pieChart.setData(pieData);
                    pieChart.invalidate();
                    break;
                case 1:
                    rootView = inflater.inflate(R.layout.n_completed_chart, container, false);
                    BarChart completedChart = rootView.findViewById(R.id.completed_chart);
                    List<BarEntry> completedEntries = new ArrayList<>();
                    HashMap<Integer, Integer> completed = ChartsPresenter.getTasksCompletedThisWeek();
                    final List<Integer> keySet = new ArrayList<Integer>(completed.keySet());
                    Collections.sort(keySet);
                    for (int i = 0; i < keySet.size(); i++) {
                        completedEntries.add(new BarEntry(i, completed.get(keySet.get(i))));
                    }
                    final String days[] = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
                    IAxisValueFormatter formatter = new IAxisValueFormatter() {

                        @Override
                        public String getFormattedValue(float value, AxisBase axis) {
                            return days[keySet.get((int) value) - 1];
                        }

                    };
                    completedChart.getXAxis().setValueFormatter(formatter);
                    completedChart.setData(new BarData(new BarDataSet(completedEntries, "Completed tasks")));
                    completedChart.invalidate();
                    break;
                default:
                    rootView = inflater.inflate(R.layout.time_spent_chart, container, false);
                    PieChart timeChart = rootView.findViewById(R.id.time_spent_chart);
                    List<PieEntry> timeEntries = new ArrayList<>();
                    for (Task task :
                            Model.getTasks()) {
                        timeEntries.add(new PieEntry(task.getTimeElapsed().getSeconds(), task.getName()));
                    }
                    PieDataSet timeDataSet = new PieDataSet(timeEntries, "Time elapsed");
                    timeDataSet.setColors(colors);
                    PieData timeData = new PieData(timeDataSet);
                    //timeData.setValueFormatter(new PercentFormatter());
                    timeData.setValueTextSize(11f);
                    timeChart.setData(timeData);
                    timeChart.invalidate();
                    break;
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Log.d("item position", Integer.toString(position));
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}
