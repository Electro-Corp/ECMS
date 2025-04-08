// Channel
#ifndef CHANNEL_H
#define CHANNEL_H

#include <Fl/Fl_Slider.h>
#include <FL/Fl_Group.H>
#include <FL/Fl_Dial.H>
#include <FL/Fl_Value_Slider.H>

namespace ECMS {


	class VolumeSlider : public Fl_Value_Slider {
		float value = 0.0;
	public:
		VolumeSlider(int x, int y, int w, int h, const char* label) : Fl_Value_Slider(x,y,w,h,label)
		{
			callback(volumeCallBack);
		}

		float getValue(){
			return value;
		}

		static void volumeCallBack(Fl_Widget* w, void * p);


		void volCallBackInternal(Fl_Widget* w, void * p);
	};

	class Channel {
	private:
		int id;

		VolumeSlider* volume;
		Fl_Dial* pan;
		Fl_Group* channelGroup;
	public:
		Channel(int id);

		void initChannelUI(Fl_Group* group, VolumeSlider* slider, Fl_Dial* dial);


		void volumeSliderUpdate(Fl_Widget* o, void* v);


		int getId() {
			return id;
		}
	};
}

#endif