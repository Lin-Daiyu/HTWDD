package com.skyworxx.htwdd;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class WidgetMensaProvider extends AppWidgetProvider {

	 private PendingIntent service = null;  
	  
	    @Override  
	    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)  
	    {  
	        final AlarmManager m = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);  
	  
	        final Calendar TIME = Calendar.getInstance();  
	        TIME.set(Calendar.MINUTE, 0);  
	        TIME.set(Calendar.SECOND, 0);  
	        TIME.set(Calendar.MILLISECOND, 0);  
	  
	        final Intent i = new Intent(context.getApplicationContext(), UpdateMensaWidgetService.class);  
	  
	        ComponentName thisWidget = new ComponentName(context,
					WidgetMensaProvider.class);
			int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

			i.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);
	        
	        if (service == null)  
	        {  
	            service = PendingIntent.getService(context, 0, i, PendingIntent.FLAG_CANCEL_CURRENT);  
	        }  
	  
	        
	
	        m.setRepeating(AlarmManager.RTC, TIME.getTime().getTime(), 1000 * 60 * 60 * 12, service);  
	     
	    }  
	  
	    @Override  
	    public void onDisabled(Context context)  
	    {  
	        final AlarmManager m = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);  
	  
	        m.cancel(service);  
	    }  
	}  