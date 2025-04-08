// Channel
#ifndef CHANNEL_H
#define CHANNEL_H

#include <Fl/Fl_Slider.h>

namespace ECMS {
	class Channel {
	private:
		int id;

		Fl_Slider* volume;
		Fl_Group* channelGroup;
	public:
		Channel(int id);

		void initChannelUI(Fl_Group* group, Fl_Slider* slider);

		int getId() {
			return id;
		}

		
	};
}

#endif