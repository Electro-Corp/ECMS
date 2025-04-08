// Channel
#ifndef CHANNEL_H
#define CHANNEL_H

#include <Fl/Fl_Slider.h>
#include <FL/Fl_Group.H>
#include <FL/Fl_Dial.H>

namespace ECMS {
	class Channel {
	private:
		int id;

		Fl_Slider* volume;
		Fl_Dial* pan;
		Fl_Group* channelGroup;
	public:
		Channel(int id);

		void initChannelUI(Fl_Group* group, Fl_Slider* slider, Fl_Dial* dial);


		void volumeSliderUpdate(Fl_Widget* o, void* v);


		int getId() {
			return id;
		}

		
	};
}

#endif