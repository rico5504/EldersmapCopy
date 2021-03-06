package com.example.eldermap;

import android.os.AsyncTask;

import com.example.eldermap.LocationPkg.FinishedTrip;
import com.example.eldermap.LocationPkg.Location;
import com.example.eldermap.LocationPkg.ScheduledTrip;
import com.example.eldermap.NetworkPkg.HTTPPostRequest;
import com.example.eldermap.ProfilePkg.BaseActivity;
import com.example.eldermap.ProfilePkg.User;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * DBQuery is a static class which holding the responsibility to connect with the
 * API server. This is a singleton.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DBQuery.class,User.class, AsyncTask.class})
public class DBQueryTest {
    static String UserID;
    static int HistoryID = 0;
    static int PlanID = 0;
    private static String baseURL = "HelloMyFriend";
    @Mock
    JSONObject object;
    @Mock
    JSONObject returnObject;

    /**
     * SetUp for later test usage.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(User.class);
        PowerMockito.mockStatic(DBQuery.class);
    }

    /**
     * Test checkUserExist.
     * If a user exist, it should return true as expected.
     * Otherwise it should return false.
     * @throws Exception
     */
    @Test
    public void checkUserExist() throws Exception{
        UserID = "HelloWorld";
        PowerMockito.when(User.getUserID()).thenReturn(UserID);

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        JSONObject returnObject = PowerMockito.mock(JSONObject.class);
        PowerMockito.when(object.put("userID", UserID)).thenReturn(returnObject);
        AsyncTask task = PowerMockito.mock(AsyncTask.class,
                Mockito.CALLS_REAL_METHODS);

        PowerMockito.when(request.execute(new JSONObject().put("userID",UserID))).thenReturn(task);

        PowerMockito.when(task.get()).thenReturn("Forbidden");

        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);
        assertEquals(true, DBQuery.checkUserExist());

    }

    /**
     * Test checkSurveryCompleted.
     * If success, return as expected.
     * @throws Exception
     */
    @Test
    public void checkSurveyCompleted() throws Exception{
        UserID = "Hello";
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);
        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        JSONObject returnObject = PowerMockito.mock(JSONObject.class);
        PowerMockito.when(object.put("userID",UserID)).
                thenReturn(returnObject);

        PowerMockito.when(DBQuery.checkSurveyCompleted()).thenReturn(true);

        assertEquals(true, DBQuery.checkSurveyCompleted());

    }

    /**
     * Test surveyComplete.
     * IF success, it should return as expected .
     * @throws Exception
     */
    @Test
    public void surveyComplete() throws Exception{
        UserID = "Hello";
        PowerMockito.mockStatic(DBQuery.class);
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);
        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);
        PowerMockito.when(DBQuery.surveyComplete()).thenReturn(true);
        assertEquals(true, DBQuery.surveyComplete());
    }

    /**
     * Test checkUserType.
     * If success, it should return as expected.
     * @throws Exception
     */
    @Test
    public void checkUserType() throws Exception{
        UserID = "Hello";
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);
        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        JSONObject returnObject = PowerMockito.mock(JSONObject.class);
        PowerMockito.when(object.put("userID", UserID)).thenReturn(returnObject);
        AsyncTask task = PowerMockito.mock(AsyncTask.class,
                Mockito.CALLS_REAL_METHODS);

        PowerMockito.when(request.execute(new JSONObject().put("userID",UserID))).thenReturn(task);
        PowerMockito.when(DBQuery.checkUserType()).thenReturn(0);
        assertEquals(0, DBQuery.checkUserType());

    }

    /**
     * Test createProfile.
     * If success, it should return as expected.
     * @throws Exception
     */
    @Test
    public void createProfile() throws Exception{
        UserID = "Hello";
        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);
        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        PowerMockito.when(DBQuery.createProfile()).thenReturn(true);
        assertEquals(true, DBQuery.createProfile());
    }

    /**
     * TEst retireveTexSize.
     * If success, it should return text size as expected.
     * @throws Exception
     */
    @Test
    public void retrieveTextSize() throws Exception{
        UserID = "Hello";
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        JSONObject returnObject = PowerMockito.mock(JSONObject.class);
        PowerMockito.when(object.put("userID", UserID)).thenReturn(returnObject);
        AsyncTask task = PowerMockito.mock(AsyncTask.class,
                Mockito.CALLS_REAL_METHODS);

        PowerMockito.when(request.execute(new JSONObject().put("userID",UserID))).thenReturn(task);

        PowerMockito.when(DBQuery.retrieveTextSize()).thenReturn(BaseActivity.MEDIUM);
        assertEquals(BaseActivity.MEDIUM, DBQuery.retrieveTextSize());

    }

    /**
     * Test retrieveWalking.
     * If success, it should return as Walking expected.
     * @throws Exception
     */
    @Test
    public void retrieveWalking() throws Exception{
        UserID = "Hello";
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        JSONObject returnObject = PowerMockito.mock(JSONObject.class);
        PowerMockito.when(object.put("userID", UserID)).thenReturn(returnObject);
        AsyncTask task = PowerMockito.mock(AsyncTask.class,
                Mockito.CALLS_REAL_METHODS);

        PowerMockito.when(request.execute(new JSONObject().
                put("userID",UserID))).thenReturn(task);

        JSONObject result = PowerMockito.mock(JSONObject.class);
        PowerMockito.when(returnObject.getJSONObject("survey")).thenReturn(result);
        PowerMockito.when(result.getInt("walking")).thenReturn(1);
        PowerMockito.when(DBQuery.retrieveWalking()).thenReturn(1);
        assertEquals(1, DBQuery.retrieveWalking());
    }

    /**
     * Test retrieveDataRpvilege.
     * If success, it should return true as expected.
     * @throws Exception
     */
    @Test
    public void retrieveDataPrivilege() throws Exception{
        UserID = "Hello";
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        JSONObject returnObject = PowerMockito.mock(JSONObject.class);
        PowerMockito.when(object.put("userID", UserID)).thenReturn(returnObject);
        AsyncTask task = PowerMockito.mock(AsyncTask.class,
                Mockito.CALLS_REAL_METHODS);

        PowerMockito.when(request.execute(new JSONObject().
                put("userID",UserID))).thenReturn(task);
        JSONObject object1 = PowerMockito.mock(JSONObject.class);
        PowerMockito.when(returnObject.getJSONObject("survey")).thenReturn(object1);
        PowerMockito.when(object1.getInt("userData")).thenReturn(1);
        PowerMockito.when(DBQuery.retrieveDataPrivilege()).thenReturn(true);
        assertEquals(true, DBQuery.retrieveDataPrivilege());

    }

    /**
     * Test updateTextSize.
     * If success, it should return true as expected.
     * @throws Exception
     */
    @Test
    public void updateTextsize() throws Exception{
        UserID = "Hello";
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

//        PowerMockito.suppress(MemberMatcher.method(JSONObject.class, "put",int.class));
        PowerMockito.suppress(MemberMatcher.method(HTTPPostRequest.class,
                "execute", JSONObject.class));
        PowerMockito.when(DBQuery.updateTextsize(10)).thenReturn(true);
        assertEquals(true, DBQuery.updateTextsize(10));

    }

    /**
     * Test updatePermission
     * If success, it should return true as expected.
     * @throws Exception
     */
    @Test
    public void updatePermission() throws Exception{
        UserID = "Hello";
        boolean test = true;
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        PowerMockito.suppress(MemberMatcher.method(HTTPPostRequest.class,
                "execute", JSONObject.class));
        PowerMockito.when(DBQuery.updatePermission(test)).thenReturn(true);
        assertEquals(true, DBQuery.updatePermission(test));

    }

    /**
     * Test updateWalking. Update a new walking.
     * If success, it should return true as expected.
     * @throws Exception
     */
    @Test
    public void updateWalking() throws Exception{
        UserID = "Hello";
        int walking = 0;
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        PowerMockito.suppress(MemberMatcher.method(HTTPPostRequest.class,
                "execute", JSONObject.class));
        PowerMockito.when(DBQuery.updateWalking(walking)).thenReturn(true);
        assertEquals(true, DBQuery.updateWalking(walking));

    }

    /**
     * Test retrievePlan.
     * If success, it should return a list of ScheduledTrip as expected.
     * @throws Exception
     */
    @Test
    public void retrievePlan() throws Exception{
        UserID = "Hello";
        ArrayList<ScheduledTrip> list = new ArrayList<>();

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);
        Location loc = PowerMockito.mock(Location.class);
        PowerMockito.whenNew(Location.class).withAnyArguments().thenReturn(loc);

        PowerMockito.when(DBQuery.retrievePlan()).thenReturn(list);
        assertEquals(list, DBQuery.retrievePlan());
    }

    /**
     * Test retrieveHistory.
     * If success, it should return a list of FinishedTrip as expected.
     * @throws Exception
     */
    @Test
    public void retrieveHistory() throws Exception{
        UserID = "Hello";
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);

        ArrayList<FinishedTrip> list = new ArrayList<>();
        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        PowerMockito.when(DBQuery.retrieveHistory()).thenReturn(list);
        assertEquals(list, DBQuery.retrieveHistory());


    }

    /**
     * Test addUserPlan.
     * If success, it should return true as expected.
     * @throws Exception
     */
    @Test
    public void addUserPlan() throws Exception{
        UserID = "Hello";
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);
        ScheduledTrip trip = PowerMockito.mock(ScheduledTrip.class);
        boolean test = true;

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);
        PowerMockito.suppress(MemberMatcher.method(HTTPPostRequest.class,
                "execute", JSONObject.class));

        PowerMockito.when(DBQuery.addUserPlan(trip)).
                thenReturn(test);
        assertEquals(test, DBQuery.addUserPlan(trip));

    }

    /**
     * Test deleteUserPlan
     * If success, it should return true as expected.
     * @throws Exception
     */
    @Test
    public void deleteUserPlan() throws Exception{
        UserID = "Hello";
        int tripID = 0;
        boolean test = true;
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);
        PowerMockito.suppress(MemberMatcher.method(HTTPPostRequest.class,
                "execute", JSONObject.class));

        PowerMockito.when(DBQuery.deleteUserPlan(tripID)).thenReturn(true);
        assertEquals(test, DBQuery.deleteUserPlan(tripID));

    }

    /**
     * Test addUSerHistory
     * If success, it should return true as expected.
     * @throws Exception
     */
    @Test
    public void addUserHistory() throws Exception{
        UserID = "Hello";
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);
        FinishedTrip trip = PowerMockito.mock(FinishedTrip.class);
        boolean test = true;

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        PowerMockito.suppress(MemberMatcher.method(HTTPPostRequest.class,
                    "execute", JSONObject.class));

        PowerMockito.when(DBQuery.addUserHistory(trip)).thenReturn(true);
        assertEquals(test, DBQuery.addUserHistory(trip));


    }

    /**
     * Test checkHistoryTripExists.
     * If success, it should return true as expected.
     * @throws Exception
     */
    @Test
    public void checkHistoryTripExists() throws Exception{
        UserID = "Hello";
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);
        int tripID = 0;

        boolean test = true;

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        PowerMockito.suppress(MemberMatcher.method(HTTPPostRequest.class,
                "execute", JSONObject.class));

        PowerMockito.when(DBQuery.checkHistoryTripExists(tripID)).thenReturn(true);
        assertEquals(test, DBQuery.checkHistoryTripExists(tripID));

    }

    /**
     * Test createHistoryID
     * If success, it should return HitoryID as expected.
     */
    @Test
    public void createHistoryID() {
        DBQuery.createHistoryID();
        assertEquals(HistoryID, DBQuery.createHistoryID());

    }

    /**
     * Test createPlanID.
     * If success, it should return PlanId as expected.
     */
    @Test
    public void createPlanID() {
        DBQuery.createPlanID();
        assertEquals(PlanID, DBQuery.createPlanID());
    }

    /**
     * Test updateHistoryReview.
     * If success, it should return as expected.
     * @throws Exception
     */
    @Test
    public void updateHistoryReview() throws Exception{
        UserID = "Hello";
        int tripID =0;
        float destinationMark= 0.0f, navigationMark = 0.0f;
        PowerMockito.when(DBQuery.checkUserExist()).thenReturn(true);
        PowerMockito.when(DBQuery.checkHistoryTripExists(tripID)).thenReturn(true);

        boolean test = true;

        HTTPPostRequest request = PowerMockito.mock(HTTPPostRequest.class);
        PowerMockito.whenNew(HTTPPostRequest.class).withAnyArguments().
                thenReturn(request);

        JSONObject object = PowerMockito.mock(JSONObject.class);
        PowerMockito.whenNew(JSONObject.class).withNoArguments().
                thenReturn(object);

        PowerMockito.suppress(MemberMatcher.method(HTTPPostRequest.class,
                "execute", JSONObject.class));
        assertEquals(false, DBQuery.updateHistoryReview(tripID,
                destinationMark, navigationMark));
    }
}